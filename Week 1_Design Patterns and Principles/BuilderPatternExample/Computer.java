package BuilderPatternExample;

public class Computer {
    // Attributes
    private String CPU;
    private int RAM;
    private int storage;

    private Computer(Builder builder)
    {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
    }

    public String getCPU() { return CPU; }
    public int getRAM() { return RAM; }
    public int getStorage() { return storage; }

    public String toString() {
        return this.CPU +", "+this.RAM+", "+this.storage;
    }
    public static class Builder
    {
        // Required parameters
        private String CPU;
        private int RAM;
        private int storage;

        public Builder(String CPU, int RAM, int storage) {
            this.CPU = CPU;
            this.RAM = RAM;
            this.storage = storage;
        }

        public Builder setCPU(String CPU) {
            this.CPU=CPU;
            return this;
        }

        public Builder setRAM(int RAM) {
            this.RAM=RAM;
            return this;
        }
        public Builder setstorage(int storage) {
            this.storage=storage;
            return this;
        }

        public Computer build()
        {
            return new Computer(this);
        }
    }
}
