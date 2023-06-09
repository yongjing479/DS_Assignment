package org.example;

import java.util.ArrayList;
import java.time.LocalDate;

public class Friend<T extends Comparable<User>> {

    Vertex<T> head; //the first account
    int size; //number of account

    public Friend(){
        head = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    /**
     *  Check does the user account exists in the graph
     * @param v
     * @return true when user account is available in the database
     */
    public boolean hasVertex(User v){
        if(head == null) return false;
        Vertex<T> temp = head;
        while(temp != null){
            if(temp.vertexInfo.compareTo(v) == 0) return true;
            temp = temp.nextVertex;
        }
        return false;
    }

    /**
     * remove the user from the friend list from two user once one of the user unfriend another user
     * @param user1: User, user2: User
     * @return true if unfriend successfully
     */
    private boolean removeFriend(User user1, User user2){
        return removeRelationship(user1, user2) && removeRelationship(user2,user1);
    }

    /**
     * remove the user account when the admin delete user account
     * @param username: String
     * @return true if remove successfully
     */
    public boolean removeAccount(String username){
        boolean result = false;
        if(size == 0){
            return false;
        }
        else{
            Vertex<T> temp = head;
            Vertex<T> previous = null;
            while(temp != null){
                if(temp.vertexInfo.getUsername().compareTo(username) == 0){
                    Vertex<T> current = temp; //the vertex want to remove

                    Vertex<T> friendVertex = current.firstEdge.toVertex;
                    Edge<T> friendEdge = current.firstEdge;
                    while(friendEdge != null) {
                        result =removeRelationship(friendVertex.vertexInfo, current.vertexInfo);
                        friendEdge = friendEdge.nextEdge;
                        if(friendEdge != null){
                            friendVertex = friendEdge.toVertex;
                        }
                    }
                    if (previous != null) {
                        previous.nextVertex = current.nextVertex; // connect the previous vertex to the next vertex
                    } else {
                        head = current.nextVertex; // update the head reference if the first vertex is removed
                    }
                    size--;
                }
                previous = temp;
                temp = temp.nextVertex;
            }
        }
        return result;
    }

    /**
     * remove the relationship between two user
     * @ sourceVertex: Vertex, destinationVertex: Vertex
     * @return true
     */
    private boolean removeRelationship(User source, User destination){
        if(head == null) return false;
        if(!hasVertex(source) || !hasVertex(destination)) return false;
        Vertex<T> sourceVertex = head;
        while(sourceVertex != null){
            if(sourceVertex.vertexInfo.compareTo(source) == 0){
                Edge<T> beforeEdge = sourceVertex.firstEdge;
                Edge<T> currentEdge = sourceVertex.firstEdge;
                while(currentEdge != null){
                    if(currentEdge.toVertex.vertexInfo.compareTo(destination)==0){
                        if (beforeEdge != currentEdge && currentEdge != null) {
                            beforeEdge.nextEdge = currentEdge.nextEdge; // remove the current edge from the list
                        }
                        else {
                            sourceVertex.firstEdge = currentEdge.nextEdge; // update the firstEdge reference if the first edge is removed
                        }
                        sourceVertex.numOfFriends--;
                        return true;
                    }
                    else{
                        beforeEdge = currentEdge;
                        currentEdge = currentEdge.nextEdge;
                    }
                }
            }
            sourceVertex = sourceVertex.nextVertex;
        }
        return false;
    }

    /**
     * Once an account is created, one vertex with User is added in the graph
     * @param v
     * @return true when the account is added in the database successfully
     */
    public boolean addVertex(User v){
        if(hasVertex(v) == false){
            Vertex<T> temp = head;
            Vertex<T> newVertex = new Vertex<>(v,null,null);
            if(head == null) head = newVertex;
            else{
                Vertex<T> previous = head;
                while(temp != null){
                    previous = temp;
                    temp = temp.nextVertex;
                }
                previous.nextVertex = newVertex;
            }
            size++;
            return true;
        }
        else return false;
    }

    /**
     * //Add new relationship between two user as friends
     * @param source
     * @param destination
     * @param
     * @return return true when the user add friend succuessfully
     */

    private boolean addEdge(User source, User destination){
        if(head == null) return false;
        if(!hasVertex(source) || !hasVertex(destination)) return false;
        Vertex<T> sourceVertex = head;
        while(sourceVertex != null){
            if(sourceVertex.vertexInfo.compareTo(source) == 0){
                Vertex<T> destinationVertex = head;
                while(destinationVertex != null){
                    if(destinationVertex.vertexInfo.compareTo(destination) == 0){
                        Edge<T> currentEdge = sourceVertex.firstEdge;
                        Edge<T> newEdge = new Edge<>(destinationVertex,currentEdge);
                        sourceVertex.firstEdge = newEdge;
                        destinationVertex.numOfFriends++;
                        return true;
                    }
                    destinationVertex = destinationVertex.nextVertex;
                }
            }
            sourceVertex = sourceVertex.nextVertex;
        }
        return false;
    }


    /**
     * Once the user accept the friend request, both of them will become friends
     * @param source
     * @param destination
     * @param
     * @return true when both success become friends
     */
    public void addFriend(User source, User destination){
        boolean result = addEdge(source,destination) && addEdge(destination,source);
        if(result) System.out.println("Added successfully");
    }

    /**
     * Store the account which has relations to the specific user in order to store in dataset
     * @param v
     * @return the list of adjacent account in ArrayList
     */
    //return all the neighbours of a vertex to an ArrayList
    public ArrayList<User> getNeighbours(User v){
        if(!hasVertex(v)) return null;
        ArrayList<User> list = new ArrayList<>();
        Vertex<T> temp = head;
        while(temp != null){
            if(temp.vertexInfo.compareTo(v) == 0){
                Edge<T> currentEdge = temp.firstEdge;
                while(currentEdge != null){
                    list.add(currentEdge.toVertex.vertexInfo);
                    currentEdge = currentEdge.nextEdge;
                }
            }
            temp = temp.nextVertex;
        }
        return list;
    }

    /**
     * print All the vertex and each of its edges
     */
    public void printEdges(){
        Vertex<T> temp= head;
        while(temp != null){
            System.out.print("# " + temp.vertexInfo.getUsername() + " : ");
            Edge<T> currentEdge = temp.firstEdge;
            while(currentEdge != null){
                System.out.print("[" + temp.vertexInfo.getUsername() + "," + currentEdge.toVertex.vertexInfo.getUsername() +"] ");
                currentEdge = currentEdge.nextEdge;

            }
            System.out.println();
            temp = temp.nextVertex;
        }
    }

}



class Vertex<T extends Comparable<User>>{
    User vertexInfo; //store User
    int numOfFriends;  //number of friends
    Vertex<T> nextVertex;
    Edge<T> firstEdge;

    public Vertex(){
        vertexInfo = null;
        numOfFriends = 0;
        nextVertex = null;
        firstEdge = null;
    }

    public Vertex(User info, Vertex<T> nextVertex, Edge<T> firstEdge){
        vertexInfo = info;
        numOfFriends = 0;
        this.nextVertex = nextVertex;
        this.firstEdge = firstEdge;
    }




}




class Edge<T extends Comparable<User>>{
    Vertex<T> toVertex;
    int weight;
    Edge<T> nextEdge;

    public Edge(){
        toVertex = null;
        weight = 0;
        nextEdge = null;
    }

    public Edge(Vertex<T> destination, Edge<T> toEdge){
        toVertex = destination;
        weight = 1;
       nextEdge = toEdge;
    }


}
