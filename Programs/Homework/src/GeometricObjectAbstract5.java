public abstract class GeometricObjectAbstract5 
{
  protected String color = "white";
  protected boolean filled;
  protected java.util.Date dateCreated;
  abstract double getArea();
  abstract double getPerimeter();
  
  /** Construct a default geometric object */
  public GeometricObjectAbstract5() 
  {
    dateCreated = new java.util.Date();
  }
  
  /** Construct a geometric object with the specified color 
    *  and filled value */
  public GeometricObjectAbstract5(String color, boolean filled) 
  {
    dateCreated = new java.util.Date();
    this.color = color;
    this.filled = filled;
  }
  /** Return color */
  public String getColor() 
  {
    return color;
  }

  /** Set a new color */
  public void setColor(String color) 
  {
    this.color = color;
  }

  /** Return filled. Since filled is boolean, 
     its get method is named isFilled */
  public boolean isFilled() 
  {
    return filled;
  }

  /** Set a new filled */
  public void setFilled(boolean filled) 
  {
    this.filled = filled;
  }
  
  /** Get dateCreated */
  public java.util.Date getDateCreated() 
  {
    return dateCreated;
  }
  
  /** Return a string representation of this object */
  public String toString() 
  {
    return "created on " + dateCreated + 
           "\ncolor: " + color + 
           " and filled: " + filled;
  }
}
