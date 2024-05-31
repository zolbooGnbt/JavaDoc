import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HeroesOfCodeAndLogicVII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Hero> heros = new ArrayList<>();
        for(; n > 0; n--) {
            heros.add(new Hero(scanner.nextLine()));
        }
        String command = scanner.nextLine();
        while(!"End".equals(command)) {
            String[] commandArray = command.split(" - ");
            switch (commandArray[0]) {
                case "CastSpell":
                    heros.stream().filter(hero -> hero.getName().equals(commandArray[1]) && hero.getHp() > 0).forEach(
                            hero -> hero.castSpell(Integer.parseInt(commandArray[2]), commandArray[3])
                    );
                    break;
                case "TakeDamage":
                    heros.stream().filter(hero -> hero.getName().equals(commandArray[1]) && hero.getHp() > 0).forEach(
                            hero -> hero.takeDamage(Integer.parseInt(commandArray[2]), commandArray[3])
                    );
                    break;
                case "Recharge":
                    heros.stream().filter(hero -> hero.getName().equals(commandArray[1]) && hero.getHp() > 0).forEach(
                            hero -> hero.recharge(Integer.parseInt(commandArray[2]))
                    );
                    break;
                case "Heal":
                    heros.stream().filter(hero -> hero.getName().equals(commandArray[1]) && hero.getHp() > 0).forEach(
                            hero -> hero.heal(Integer.parseInt(commandArray[2]))
                    );
                    break;
                default: break;
            }
            command = scanner.nextLine();
        }

        heros.stream().filter(x -> x.getHp() > 0).forEachOrdered(
                hero -> System.out.printf("%s%n  HP: %d%n  MP: %d%n", hero.getName(), hero.getHp(), hero.getMp())
        );
    }

    public static class Hero {
        private String name;
        private int hp;
        private int mp;

        public Hero(String input) {
            String[] data = input.split(" ");
            this.name = data[0];
            this.hp = Math.min(Integer.parseInt(data[1]), 100);
            this.mp = Math.min(Integer.parseInt(data[2]), 200);
        }

        public void castSpell(int mp, String spell) {
            if (mp > this.mp) {
                System.out.printf("%s does not have enough MP to cast %s!%n", this.name, spell);
            } else {
                this.mp -= mp;
                System.out.printf("%s has successfully cast %s and now has %d MP!%n",
                        this.name, spell, this.mp);
            }
        }

        public void takeDamage(int damage, String attacker) {
            if (damage >= this.hp) {
                this.hp = 0;
                System.out.printf("%s has been killed by %s!%n", this.name, attacker);
            } else {
                this.hp -= damage;
                System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n",
                        this.name, damage, attacker, this.hp);
            }
        }

        public void recharge(int amount) {
            int current = this.mp;
            this.mp = Math.min(this.mp + amount, 200);
            System.out.printf("%s recharged for %d MP!%n", this.name, Math.min(amount, 200 - current));
        }

        public void heal(int amount) {
            int current = this.hp;
            this.hp = Math.min(this.hp + amount, 100);
            System.out.printf("%s healed for %d HP!%n", this.name, Math.min(amount, 100 - current));
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getHp() {
            return hp;
        }

        public void setHp(int hp) {
            this.hp = hp;
        }

        public int getMp() {
            return mp;
        }

        public void setMp(int mp) {
            this.mp = mp;
        }
    }
}
