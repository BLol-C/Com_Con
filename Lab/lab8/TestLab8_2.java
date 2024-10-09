package lab8;

import java.util.Iterator;

import lab8.lab8_2.Containers;

public class TestLab8_2 {
	public static void main(String[] args) {
    	    	
//    	class NameRepository implements Containers {
//    	    String[] names = { "John", "May", "Ryan" };
//
//    	    @Override
//    	    public Iterator getIterator() {
//    	        return new Iterator() {
//    	            int index = 0;
//
//    	            @Override
//    	            public boolean hasNext() {
//    	                if (index < names.length)
//    	                    return true;
//    	                return false;
//    	            }
//
//    	            @Override
//    	            public Object next() {
//    	                return names[index++];
//    	            }
//
//    	            public void remove() {
//
//    	            }
//    	        };
//    	    }
//
//
//    	}
		
//    	NameRepository namesRepository = new NameRepository() {
//    	Containers namesRepository = new Containers() {
		Containers namesRepository = ()-> {
        	String[] names = { "John", "May", "Ryan" };

//    	    @Override
//    	    public Iterator getIterator() {
    	        return new Iterator() {
    	            int index = 0;

    	            @Override
    	            public boolean hasNext() {
    	                if (index < names.length)
    	                    return true;
    	                return false;
    	            }

    	            @Override
    	            public Object next() {
    	                return names[index++];
    	            }

    	            public void remove() {

    	            }
    	        };
    	    

        };
        for (Iterator iter = namesRepository.getIterator(); iter.hasNext();){
            String name = (String) iter.next();
            System.out.println("Name : " + name);
        }
    }
}
