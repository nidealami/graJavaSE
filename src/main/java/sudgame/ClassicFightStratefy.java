package sudgame;

import domain.NPC;
import domain.Player;

import java.util.Random;

public class ClassicFightStratefy implements FightStrategy {
    public ClassicFightStratefy() {
    }

    @Override
    public void fight(Player player, NPC targetNPC) {
        int hit = 0;
        while (player.isAlive() && targetNPC.isAlive()) {

            boolean targetStillHere = player.isThereNPCNearby(targetNPC);

            if (!targetStillHere) {
                System.out.println("Your target is no longer here.");
                return;
            }

            try {
                hit = calculateHitStrength(player.getStrength());
                showHitMessage(targetNPC, hit);
                targetNPC.damageTaken(hit);
                Thread.sleep(2000);
                hit = calculateHitStrength(targetNPC.getStrength());
                showHitMessage(hit);
                player.damageTaken(hit);
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                System.out.println("Caly terror rozpetal error");
            }
        }

        if (player.isAlive() && !targetNPC.isAlive()) {
            System.out.println("You are victorious!");
        } else if ((!player.isAlive() && targetNPC.isAlive())) {
            System.out.println("Try harder next time");
        } else {
            System.out.println("Run away!");
        }
    }

    private int calculateHitStrength(int strength) {
        Random r = new Random();
        return strength + r.nextInt(4);
    }

    private void showHitMessage(NPC targetNPC, int hit) {
        System.out.println("You hit " + targetNPC.getName() + " for " + hit + " damage.");
    }

    private void showHitMessage(int hit) {
        System.out.println("You're hit for " + hit + " damage.");
    }
}
