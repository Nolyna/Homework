
import static java.lang.Math.sqrt;
import java.util.Scanner;


/**
 *Assignment 6
 * CSC2720
 * @author Noria Soumbou
 * PURPOSE
 *  The purpose of our program is to gain experience with using java interface, abstract class, base class and subclass.
 * DESCRIPTION
 *  The program will create different shapes, ask the user for values related to the shape (height,length,...)
 *  then it will print the result of methods call.
 * SOLUTION
 *   We created shape interface that has methods for getting volume and surface area of three-dimensional shape.
 *   Then we created classes (cubes, rectangular prisms, triangular prisms, sphere, cones and cylinders). 
 *   that are subclasses that implement shapes. 
 *   The main program invoke the methods from the classes and print the values(volume, surface area,...)
 * DATA STRUCTURE
 *  For our program we did not use any data structure.
 * CLASSE
 *  We have 6 classes: cubes, rectangular prisms, triangular prisms, sphere, cones and cylinder
 *  All representing a different three-dimensional shape 
 */

interface shapes
{
   public void volume();
   public void surfaceArea();
}

public class Shape  {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Cubes cbe = new Cubes();
        Cone coe = new Cone(3,4,5);
        Cylinder cyl = new Cylinder();
        Sphere sph = new Sphere(8);
        RectPrism rpe = new RectPrism();
        TrianPrism tpe = new TrianPrism(4,2,5);
        
        System.out.println("My cube: ");
        cbe.surfaceArea();
        cbe.volume();
        System.out.println();
        
        System.out.println("My cylinder: ");
        cyl.setHeight(7);
        cyl.setRadius(3);
        cyl.volume();
        cyl.surfaceArea();
        cyl.SurfaceAreaEnd();
        System.out.println();
        
        System.out.println("My sphere: ");
        System.out.println("the radius: "+sph.getRadius());
        sph.volume();
        sph.surfaceArea();
        System.out.println();
        
        System.out.println("My cone: ");
        coe.volume();
        coe.surfaceArea();
        coe.surfaceAreaBaes();
        coe.surfaceAreaSide();
        System.out.println();
        System.out.print("Enter new heigth cone: ");
        coe.setHeight(input.nextInt());
        coe.volume();
        coe.surfaceArea();
        System.out.println();
        
        System.out.println("My rectangular prism: ");
        rpe.setHeight(5);
        rpe.setLength(3);
        rpe.setWidth(6);
        rpe.volume();
        rpe.surfaceArea();
        System.out.println();
        
        System.out.println("My triangular prism: ");
        tpe.volume();
        System.out.println();
        tpe.surfaceArea();
    }
    
    
}

////////////////////////////////////////////////////////////////////////////////
/**
 * Class to create a sphere
 * @author Noria Soumbou
 */
class Sphere implements shapes {
    Integer radius;
    final double pi = 3.14;
    private double sa,vol;
    private Scanner userInput = new Scanner(System.in);
    
    Sphere(Integer radius){
        this.radius = radius;
    }
    /**
     * Calculate the volume of the sphere
     */
    @Override
    public void volume(){
        if(radius == null){
            System.out.println("Enter the radius: ");
            radius = userInput.nextInt();
        }
        vol = (4/3)*pi*(radius*radius*radius);
        System.out.println("The volume of the sphere is: "+vol);
    }
    /**
     * Calculate the surface area of the sphere
     */
    @Override
    public void surfaceArea(){
        if(radius == null){
            System.out.println("Enter the radius: ");
            radius = userInput.nextInt();
        }
        sa = 4*pi*(radius*radius);
        System.out.println("The surface area of the sphere is: "+sa);
    }
    
    public Integer getRadius(){
        return radius;
    }
    public void setRadius(Integer radius){
        this.radius = radius;
    }
}

//////////////////////////////////////////////////////////////////////////////////////
/**
 * Class to create a cone
 * @author Noria Soumbou
 */
class Cone implements shapes {  
    private final double pi = 3.14;
    private double sa,sab,sas,vol;
    private Integer height, side, radius;
    private Scanner userInput = new Scanner(System.in);
    
    
    Cone(){
        side = null;
        radius = null;
        height = null;
    }
    Cone(Integer height, Integer side, Integer radius){
        this.height = height;
        this.radius = radius;
        this.side = side;
    }
    /**
     * Calculate the volume of the cone
     */
    @Override
    public void volume(){
        if(height == null){
            System.out.print("Enter the height: ");
            height = userInput.nextInt();
        }
        if(radius == null){
            System.out.print("Enter the radius: ");
            radius = userInput.nextInt();
        }
        vol = (1/3)*pi*(radius*radius)*height;
        System.out.println("The volume of the cone is: "+vol);
    }
    /**
     * Calculate the surface area of the cone
     */
    @Override
    public void surfaceArea(){
        if(radius == null){
            System.out.println("Enter the radius: ");
            radius = userInput.nextInt();
        }
        if(side == null){
            System.out.println("Enter the side: ");
            side = userInput.nextInt();
        }
        sa = pi * radius * (radius + side);
        System.out.println("The surface area of the cone is: "+sa);
    }
    /**
     *  Calculate the Surface Area of Base 
     */
    public void surfaceAreaBaes(){
        if(radius == null){
            System.out.println("Enter the radius: ");
            radius = userInput.nextInt();
        }
        sab = pi * (radius*radius);
        System.out.println("The surface area of the base of the cone is: "+sab);
    }
    /**
     *  Calculate the Surface Area of Side
     */
    public void surfaceAreaSide(){
        if(radius == null){
            System.out.println("Enter the radius: ");
            radius = userInput.nextInt();
        }
        if(height == null){
            System.out.println("Enter the height: ");
            height = userInput.nextInt();
        }
        //sas = pi * radius * side;
        sas = pi * radius * sqrt((radius*radius) + (height*height));
        System.out.println("The surface area of the side of the cone is: "+sas);
    }
    
    /**
     * get radius
     * @return radius 
     */
    public Integer getRadius(){
        return radius;
    }
    /**
     * get height
     * @return height
     */
    public Integer getHeight(){
        return height;
    }
    /**
     * get side
     * @return side
     */
    public Integer getSide(){
        return side;
    }
    /**
     * set radius
     * @param radius 
     */
    public void setRadius(Integer radius){
        this.radius = radius;
    }
    /**
     * set height
     * @param height 
     */
    public void setHeight(Integer height){
        this.height = height;
    }
    /**
     * set side
     * @param side 
     */
    public void setSide(Integer side){
        this.side = side;
    }
    
}

////////////////////////////////////////////////////////////////////////////////////

/**
 * Class to create a cylinder
 * @author Noria Soumbou
 */
class Cylinder implements shapes { 
    Integer height, radius;
    private double pi = 3.14, vol, sa, sas, sae;
    private Scanner userInput = new Scanner(System.in);
     
    Cylinder(){
        height = null;
        radius = null;
    }
    Cylinder(Integer height,Integer radius){
        this.height = height;
        this.radius = radius;
    }
    /**
     * Calculate the surface area of one end of the cylinder
     */
    public void SurfaceAreaEnd() {
        if(radius == null){
            System.out.println("Enter the radius: ");
            radius = userInput.nextInt();
        }
        sae = pi*(radius*radius);
        System.out.println("The surface area of one end of the cylinder is: "+sae);
    }
    /**
     * Calculate the surface area of the side of the cylinder
     */
    public void SurfaceAreaSide(){
        if(radius == null){
            System.out.println("Enter the radius: ");
            radius = userInput.nextInt();
        }
        if(height == null){
            System.out.println("Enter the height: ");
            height = userInput.nextInt();
        }
        sas = 2 * pi * radius *height;
        System.out.println("The surface area of the cylinder is: "+sas);
    } 
    /**
     * Calculate the volume of the cylinder
     */
    @Override
    public void volume(){
        if(height == null){
            System.out.println("Enter the height: ");
            height = userInput.nextInt();
        }
        if(radius == null){
            System.out.println("Enter the radius: ");
            radius = userInput.nextInt();
        }
        vol = pi*(radius*radius)*height;
        System.out.println("The volume of the cylinder is: "+vol);
    }
    /**
     * Calculate the surface area of the cylinder
     */
    @Override
    public void surfaceArea(){
        if(height == null){
            System.out.println("Enter the height: ");
            height = userInput.nextInt();
        }
        if(radius == null){
            System.out.println("Enter the radius: ");
            radius = userInput.nextInt();
        }
        sa = 2*pi*radius*(radius+height);
        System.out.println("The surface area of the cylinder is: "+sa);
    }
    
    /**
     * get radius
     * @return radius 
     */
    public Integer getRadius(){
        return radius;
    }
    /**
     * get height
     * @return height
     */
    public Integer getHeight(){
        return height;
    }

    /**
     * set radius
     * @param radius 
     */
    public void setRadius(Integer radius){
        this.radius = radius;
    }
    /**
     * set height
     * @param height 
     */
    public void setHeight(Integer height){
        this.height = height;
    }
    
}

///////////////////////////////////////////////////////////////////////////////////
class Cubes implements shapes {  
    private Integer length, sa, vol;
    private Scanner userInput = new Scanner(System.in);
    
    Cubes(){
        length = null;
    }
    
    Cubes(Integer length){
        this.length = length;
    }    
    
    /**
     * Calculate the volume of the cube
     */
    @Override
    public void volume(){
        if(length == null){
            System.out.print("Enter the length: ");
            length = userInput.nextInt();
        }
        vol = length*length*length;
        System.out.println("The volume of the cube is: "+vol);
    }
    /**
     * Calculate the surface area of the cube
     */
    @Override
    public void surfaceArea(){
        if(length == null){
            System.out.print("Enter the length: ");
            length = userInput.nextInt();
        }
        sa = 6*(length*length);
        System.out.println("The surface area of the cube is: "+sa);
    }
    
    
    /**
     * get length
     * @return length
     */
    public Integer getlength(){
        return length;
    }
    /**
     * set length
     * @param length 
     */
    public void setLength(Integer length ){
        this.length = length;
    }
    
}

/////////////////////////////////////////////////////////////////////////////////////
/**
 * Class to create a rectangular prism
 * @author Noria Soumbou
 */
class RectPrism implements shapes {  
    private Integer length,width,height;
    private Integer sa,vol;
    private Scanner userInput = new Scanner(System.in);
    
    RectPrism(){
        length = null;
        width = null;
        height = null;
    }
    
    RectPrism(Integer l, Integer w, Integer h){
        length = l;
        width = w;
        height = h;
    }
    /**
     * Calculate the volume of the rectangular prism
     */
    @Override
    public void volume(){
        if(length == null){
            System.out.println("Enter the length: ");
            length = userInput.nextInt();
        }
        if(width == null){
            System.out.println("Enter the width: ");
            width = userInput.nextInt();
        }
        if(height == null){
            System.out.println("Enter the height: ");
            height = userInput.nextInt();
        }
        vol = length * width * height;
        System.out.println("The volume of the rectangular prism is: "+vol);
    }
    /**
     * Calculate the surface area of the rectangular prism
     */
    @Override
    public void surfaceArea(){
        if(length == null){
            System.out.println("Enter the length: ");
            length = userInput.nextInt();
        }
        if(width == null){
            System.out.println("Enter the width: ");
            width = userInput.nextInt();
        }
        if(height == null){
            System.out.println("Enter the height: ");
            height = userInput.nextInt();
        }
        sa = (2*width*length) +(2*length*height)+(2*width*height);
        System.out.println("The surface area the rectangular prism is: "+sa);
    }
    /**
     * get width of the rectangular prism
     * @return width 
     */
    public Integer getwidth(){
        return width;
    }
    /**
     * get height of the rectangular prism
     * @return height
     */
    public Integer getHeight(){
        return height;
    }
    /**
     * get length of the rectangular prism
     * @return length
     */
    public Integer getLength(){
        return length;
    }
    /**
     * set width of the rectangular prism
     * @param width 
     */
    public void setWidth(Integer width){
        this.width = width;
    }
    /**
     * set height of the rectangular prism
     * @param height 
     */
    public void setHeight(Integer height){
        this.height = height;
    }
    /**
     * set length of the rectangular prism
     * @param length 
     */
    public void setLength(Integer length){
        this.length = length;
    }
}

////////////////////////////////////////////////////////////////////////////////

/**
 * Class to create a triangular prism
 * @author Noria Soumbou
 */
class TrianPrism implements shapes {  
    private Integer length,basel,height;
    private double sa,vol;
    private Scanner userInput = new Scanner(System.in);
    
    TrianPrism(){
        length = null;
        basel = null;
        height = null;
    }
    
    TrianPrism(Integer l, Integer w, Integer h){
        length = l;
        basel = w;
        height = h;
    }
    /**
     * Calculate the volume of the triangular prism
     */
    @Override
    public void volume(){
        if(length == null){
            System.out.print("Enter the length: ");
            length = userInput.nextInt();
        }
        if(basel == null){
            System.out.print("Enter the base length: ");
            basel = userInput.nextInt();
        }
        if(height == null){
            System.out.print("Enter the height: ");
            height = userInput.nextInt();
        }
        vol = (1/2)*basel*length*height;
        System.out.println("The volume of the triangular prism is: "+vol);
    }
    /**
     * Calculate the surface area of the triangular prism
     */
    @Override
    public void surfaceArea(){
       System.out.print("Enter the lenthg of side 1: ");
       int s1 = userInput.nextInt();
       System.out.print("Enter the lenthg of side 2: ");
       int s2 = userInput.nextInt();
       System.out.print("Enter the lenthg of side 2: ");
       int s3 = userInput.nextInt();
       if(basel == null){
            System.out.println("Enter the base length: ");
            basel = userInput.nextInt();
        }
       sa = ((basel*height)/2)+((s1+s2+s3)*basel);
       System.out.println("The surface area of the triangular prism is: "+ sa);
   };
   
   /**
     * get Base length of the triangular prism
     * @return Basel Base length 
     */
    public Integer getBaselength(){
        return basel;
    }
    /**
     * get height of the triangular prism
     * @return height
     */
    public Integer getHeight(){
        return height;
    }
    /**
     * get length of the triangular prism
     * @return length
     */
    public Integer getLength(){
        return length;
    }
    /**
     * set Base length of the triangular prism
     * @param Baselength 
     */
    public void setBaselength(Integer Baselength){
        this.basel = Baselength;
    }
    /**
     * set height of the triangular prism
     * @param height 
     */
    public void setHeight(Integer height){
        this.height = height;
    }
    /**
     * set length of the triangular prism
     * @param length 
     */
    public void setLength(Integer length){
        this.length = length;
    }
}