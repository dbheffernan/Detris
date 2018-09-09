
public class Level {
    public int level;
    
    Level(){
        this.level=1;
        System.out.println("boom");
    }
    public int getLevel(int score){
        if(score==0)
            return 1;
        if(score>200)
            return 9;
        else
            return (int)(score / 10)+1;
    }
}
