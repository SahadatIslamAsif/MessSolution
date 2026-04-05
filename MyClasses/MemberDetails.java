package MyClasses;

class MemberDetails {
    private String name;
    private int bazar1;
    private int bazar2;
    private int bazar3;
    private int personalBazar;
    private int mealCount;
    private int additionalCost;

    public MemberDetails(String name, int bazar1, int bazar2, int bazar3, int personalBazar, int mealCount,
            int additionalCost) {
        this.name = name;
        this.bazar1 = bazar1;
        this.bazar2 = bazar2;
        this.bazar3 = bazar3;
        this.personalBazar = personalBazar;
        this.mealCount = mealCount;
        this.additionalCost = additionalCost;
    }

    public String getName() {
        return name;
    }

    public int getBazar1() {
        return bazar1;
    }

    public int getBazar2() {
        return bazar2;
    }

    public int getBazar3() {
        return bazar3;
    }

    public int getPersonalBazar() {
        return personalBazar;
    }

    public int getMealCount() {
        return mealCount;
    }

    public int getAdditionalCost() {
        return additionalCost;
    }

    public void setBazar1(int bazar1) {
        this.bazar1 = bazar1;
    }

    public void setBazar2(int bazar2) {
        this.bazar2 = bazar2;
    }

    public void setBazar3(int bazar3) {
        this.bazar3 = bazar3;
    }

}