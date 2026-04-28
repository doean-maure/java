public class Task16 {

    interface Animal {
        boolean feed(boolean timeToEat); 
        void groom(); 
        void pet(); 
    }

     public static class Gorilla implements Animal {

        public void groom() {
            //lather, rinse, repeat
            System.out.println("Clean the gorilla");
        }

        public void pet() {
            //pet at your own risk
            System.out.println("Pet the gorilla");
        }

        public boolean feed(boolean timeToEat) {
            if (timeToEat) {
                System.out.println("The gorilla is eating");
            } return false;   
        }
    }

    public static void main(String[] args) {
        Gorilla Gorilla = new Gorilla();
        
        Gorilla.groom();
        Gorilla.pet();
        Gorilla.feed(true);
    }
}
        
    


    

