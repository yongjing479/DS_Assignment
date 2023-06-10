package org.example;

import java.util.LinkedList;

public class TraceBack<T> {
    LinkedList<Object> history;
    int currentPage;

    /** Constructor */
    public TraceBack(){
        history = new LinkedList<>();
        currentPage = 0;
    }

    /**
     * Add the page to the history when the user look at the new page.
     * When the user has trace back and look to the new page, the history will remove the page which has been trace back and add the new page after the current page
     * @param webpage: Object
     */
    public void addHistory (Object webpage){
        if(currentPage == history.size()){
            history.add(webpage);
            currentPage++;
        }
        else{
            LinkedList<Object> history = new LinkedList<>();
            for (int i = 0; i < currentPage; i++) {
                history.add(this.history.get(i));
            }
            history.add(webpage);
            currentPage++;
            this.history = history;
        }
    }

    /**
     * Use to trace back from the history
     * @return Object
     */
    public Object trackBack(){
        if(currentPage == 1){
            return "Already at the first page";
        }
        else{
            currentPage--;
            return history.get(currentPage-1);
        }
    }

    /**
     * Trace forward the pages which looked before you trace back
     * @return Object
     */
    public Object traceForward(){
        if(currentPage == history.size()){
            return "Already at the latest page";
        }
        else{
            currentPage++;
            return history.get(currentPage-1);
        }
    }

    /**
     * print all contents in the history
     * Show the current pages user is looking
     */
    public void printHistory(){
        if(history.size() == 0) System.out.println("No history available");
        else{
            System.out.print("History: [");
            for (int i = 0; i < history.size(); i++) {
                System.out.print(history.get(i) + " > ");
            }
            System.out.println("]");
            System.out.println("Current Page: " + history.get(currentPage-1));
        }
    }

    public static void main(String[] args) {
        TraceBack history = new TraceBack();
        history.addHistory("mainPage");
        history.addHistory("FriendList");
        history.addHistory(123);
        history.addHistory('a');
        history.printHistory();
        System.out.println();

        System.out.println("Trace Back");
        System.out.println(history.trackBack());
        System.out.println(history.trackBack());
        System.out.println(history.trackBack());
        history.printHistory();
        System.out.println();

        System.out.println("Go to new webpage");
        history.addHistory("search User profile");
        history.addHistory("Search mutual friend");
        history.printHistory();
        System.out.println();

        System.out.println("Trace Back");
        System.out.println(history.trackBack());  //Search User profile
        System.out.println(history.trackBack()); //mainPage
        System.out.println(history.trackBack());    //Already at the first page
        history.printHistory();
        System.out.println();

        System.out.println("Trace Forward");
        System.out.println(history.traceForward());
        history.printHistory();
        System.out.println(history.traceForward());
        history.printHistory();
        System.out.println(history.traceForward());     //Already at the latest page

    }

}
