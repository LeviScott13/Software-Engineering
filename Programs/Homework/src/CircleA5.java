public class CircleA5 
   extends GeometricObjectAbstract5 
   {
   private double radius;

   public CircleA5() 
   {
   }

   public CircleA5(double radius) 
   {
     this.radius = radius;
   }

   public CircleA5(double radius, String color, boolean filled) 
   {
     this.radius = radius;
     setColor(color);
     setFilled(filled);
   }
   
   /** Return radius */
   public double getRadius() 
   {
     return radius;
   }
   
   /** Set a new radius */
   public void setRadius(double radius) 
   {
     this.radius = radius;
   }
   
   /** Return area */
   public double getArea() 
   {
     return radius * radius * Math.PI;
   }
   
   /** Return diameter */
   public double getDiameter() 
   {
     return 2 * radius;
   }
  
   /** Return perimeter */
   public double getPerimeter() 
   {
     return 2 * radius * Math.PI;
   }
   
   /* Print the circle info */
   public String toString()
   {
     String result = "\nCircle Information" +
                     "\n" + super.toString() +
                     "\nRadius is:      " + radius +
                     "\nArea is:        " + getArea()+
                     "\nPerimeter is:   " + getPerimeter();
                       
               
     return result;
    }
}