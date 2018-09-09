import javax.swing.ImageIcon;

public class Pic {
    public ImageIcon img;
    
    Pic(){
         img = new ImageIcon("Level1.jpeg");
    }
    public ImageIcon getPic(){
        return img;
    }
    public void setPic(int level){
        String name = "Level";
        name = name.concat(String.valueOf(level)).concat(".jpeg");
        img = new ImageIcon(name);
        System.out.println(name);
    }
}

