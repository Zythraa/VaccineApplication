public class Magazines
{
    private String title;
    private String material; 
    private int noOfPages;
    
    //normal construtor
    public Magazines(String title, String material, int noOfPages)
    {
        this.title = title;
        this.material = material;
        this.noOfPages = noOfPages ;
    }
    
    //default constructor
    public Magazines()
    {
        this.title = "";
        this.material = "";        
        this.noOfPages = 0;
    }
    
    //accsessor 
    public String gettitle()
    {
        return title;
    }

    public String getmaterial()
    {
        return material;
    }

    public int getnoOfPages()
    {
        return noOfPages;
    }

  
    //mutator for all attributes
    public void setMagazines(String t, String m, int n)
    {
        title = t;
        material = m;
        noOfPages = n;
    }
    
    //processor
    public double calcCost(String m,int n )
    {
        double cost = 0.0;
        double price ;
        double p = 0.08;
        
        
        if(material.equalsIgnoreCase("gamblo"))
        {
            price = 5.50;
            cost = (n*p) + (1.5*price);
            
        }
        else if(material.equalsIgnoreCase("wood"))
        {
            price = 4.80;
            cost = (n*p) + (1.5*price);
            
        }
        
        else{
            System.out.print("\nPlease enter correct material");
        }
        
        return cost;
        
           
    }

    //printer
    public String toString()
    {
        return ("\nTitle: " + title + "\nMaterial: " + material + "\nNumber Of Pages:" + noOfPages + "\nTotal Cost: " + calcCost(material, noOfPages));
    }
}