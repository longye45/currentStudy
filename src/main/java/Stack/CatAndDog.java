package Stack;

import java.util.LinkedList;
import java.util.Queue;

public class CatAndDog {
    private static class Pet {
        private String type;

        public Pet(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }

    private static class Dog extends Pet {
        public Dog() {
            super("Dog");
        }
    }

    private static class Cat extends Pet {
        public Cat() {
            super("Cat");
        }
    }

    private static class PetEnterQueue {
        private Pet pet;
        private int count;

        public PetEnterQueue(Pet pet, int count) {
            this.pet = pet;
            this.count = count;
        }

        public Pet getPet() {
            return pet;
        }

        public int getCount() {
            return count;
        }

        public String getPetType() {
            return pet.getType();
        }
    }

    private static class PetQueue {
        private Queue<PetEnterQueue> dogQueue;
        private Queue<PetEnterQueue> catQueue;
        private int count;

        public PetQueue() {
            this.dogQueue = new LinkedList<>();
            this.catQueue = new LinkedList<>();
        }

        public void add(Pet pet) {
            if (pet.type.equals("Dog")) {
                this.dogQueue.add(new PetEnterQueue(pet, this.count++));
            } else if (pet.type.equals("Cat"))
                this.catQueue.add(new PetEnterQueue(pet, this.count++));
            else {
                throw new RuntimeException("");
            }
        }

        public Pet pollAll() {
            if (!this.catQueue.isEmpty() && !this.dogQueue.isEmpty()) {
                if (this.catQueue.peek().count < this.dogQueue.peek().count) {
                    return this.catQueue.poll().getPet();
                } else
                    return this.dogQueue.poll().getPet();
            } else if (!catQueue.isEmpty())
                return this.catQueue.poll().getPet();
            else if (!dogQueue.isEmpty())
                return this.dogQueue.poll().getPet();
            else
                throw new RuntimeException();
        }

        public Dog pollDog() {
            if (!this.dogQueue.isEmpty()) {
                return (Dog) dogQueue.poll().getPet();
            } else
                throw new RuntimeException();
        }

        public Cat pollCat() {
            if (!this.catQueue.isEmpty())
                return (Cat) this.catQueue.poll().getPet();
            else
                throw new RuntimeException();
        }

        public boolean isEmpty() {
            return this.catQueue.isEmpty() && this.dogQueue.isEmpty();
        }

        public boolean isDogQueueEmpty() {
            return this.dogQueue.isEmpty();
        }

        public boolean isCatQueueEmpty() {
            return this.catQueue.isEmpty();
        }
    }
}
