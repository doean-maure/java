public class Task15 {
    public interface Shape {
        double calculateArea();
        double calculatePerimeter();
    }   
   
    public static abstract class AbstractShape implements Shape {   
        protected String color;
        protected double length;
        protected double width;
    
        public AbstractShape(String color, double length, double width) {
            this.color = color;
            this.length = length;
            this.width = width;
        }
    }
    
    public static class Circle extends AbstractShape {
        private double radius;
        
        public Circle(String color, double radius) {
            super(color, 0, 0); 
            this.radius = radius;
        }

        @Override
        public double calculateArea() {
            // Formula: PI * r^2
            return Math.PI * radius * radius;
        }

        @Override
        public double calculatePerimeter() {
            // Formula: 2 * PI * r
            return 2 * Math.PI * radius;
        }
    }

    public static class Rectangle extends AbstractShape {
        public Rectangle(String color, double length, double width) {
            super(color, length, width);
        }

        @Override
        public double calculateArea() {
            // Formula: L * W
            return length * width;
        }

        @Override
        public double calculatePerimeter() {
            // Formula: 2 * (L + W)
            return 2 * (length + width);
        }         
    }
    
    public static void main(String[] args) {
        Circle circle = new Circle("Red", 7.0);
        Rectangle rectangle = new Rectangle("Blue", 40, 60);
        
        System.out.println("CIRCLE");
        System.out.println("Area: " + circle.calculateArea());
        System.out.println("Perimeter: " + circle.calculatePerimeter() + "\n");
        
        System.out.println("RECTANGLE");
        System.out.println("Area: " + rectangle.calculateArea());
        System.out.println("Perimeter: " + rectangle.calculatePerimeter());
    }    
}



        

    




