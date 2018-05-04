import java.util.Observable;
import java.util.Random;

public class Game extends Observable implements Runnable {


    private String name;
    private int teamAScore;
    private int teamBScore;
    private String score;
    private boolean teamAHasBall;
    private Random random;

    public Game(String name){
        super();
        this.name = name;
        random = new Random();
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getTeamAScore(){
        return teamAScore;
    }

    public void setTeamAScore(int teamAScore){
        this.teamAScore = teamAScore;
    }

    public int getTeamBScore(){
        return teamBScore;
    }

    public void setTeamBScore(int teamBScore){
        this.teamBScore = teamBScore;
    }

    public void setScore(String score){
        this.score = score;
        setChanged();
        notifyObservers(score); //Pass through here what we want to the observers, in this case it would be the score
    }

    public boolean isTeamAHasBall(){
        return teamAHasBall;
    }

    public void setTeamAHasBall(boolean newStatus){
        this.teamAHasBall = newStatus;
    }

    public Random getRandom(){
        return random;
    }

    public void setRandom(Random random){
        this.random = random;
    }



    @Override
    public void run() {
        while(true){
            if(teamAHasBall){
                setTeamAScore(teamAScore + random.nextInt(3));
            }else{
                setTeamBScore(teamBScore + random.nextInt(3));
            }

            teamAHasBall = !teamAHasBall;
            setScore(teamAScore + ":" + teamBScore);

            try{
                Thread.sleep(2000);

            }catch(InterruptedException e){
                e.printStackTrace();
            }

        }
    }

    @Override
    public String toString() {
        return this.name;
    }
}
