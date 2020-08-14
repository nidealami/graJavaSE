import java.util.Random;

public class FightThread implements Runnable {

    private Player player;
    private NPC targetNPC;

    public FightThread(Player player, NPC targetNPC) {
        this.player = player;
        this.targetNPC = targetNPC;
    }

    private int calcHitStrenght(int strength) {
        Random r = new Random();
        return strength + r.nextInt(4);
    }

    private void showHitMessage(NPC targetNPC, int hit) {
        System.out.println("You hit " + targetNPC.getName() + "for " + hit + "damage");
    }

    private void showHitMessage(int hit) {
        System.out.println("You were hit for " + hit + "damage");
    }

    @Override
    public void run() {
        int hit = 0;
        while (player.isAlive() && targetNPC.isAlive()) {
            try {
                hit = calcHitStrenght(player.getStrength());
                showHitMessage(targetNPC, hit);
                targetNPC.damageTaken(hit);
                Thread.sleep(200);
                hit = calcHitStrenght(targetNPC.getStrength());
                showHitMessage(hit);
                player.damageTaken(hit);
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (player.isAlive()) {
            System.out.println("Target died");

        } else {
            System.out.println("Sorry, You died");
        }

    }
}
