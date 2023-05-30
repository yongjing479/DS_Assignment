package org.example;

import java.util.ArrayList;

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
     *     find the index of the vertex
     * @param v
     * @return the index of the account id
     */
    public int getIndex(User v){
        Vertex<T> temp = head;
        int pos = 0;
        while(temp != null){
            if(temp.vertexInfo.compareTo(v) == 0) return pos;
            temp = temp.nextVertex;
            pos ++;
        }
        return -1;
    }

    /**
     * get vertex info at a specific index position
     * @param pos
     * @return the user account
     */
    public User getVertex(int pos){
        if(pos> size -1 || pos<0) return null;
        Vertex<T> temp = head;
        for (int i = 0; i < pos; i++) {
            temp = temp.nextVertex;
        }
        return (User)temp.vertexInfo;
    }

    /**
     * //Add new relationship between two user as friends
     * @param source
     * @param destination
     * @param
     * @return return true when the user add friend succuessfully
     */

    public boolean addEdge(User source, User destination){
        if(head == null) return false;
        if(!hasVertex(source) || hasVertex(destination)) return false;
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
}



class Vertex<T extends Comparable<User>>{
    User vertexInfo; //store User
    int numOfFriends;  //number of friends
    //int outdeg;
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
