package Financial;
public class InsuranceObligation {
    String name;
    double riskLevel;
    double cost;
    public InsuranceObligation(String name,double riskLevel,double cost){
        this.name=name;
        this.riskLevel = riskLevel;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public double getRiskLevel() {
        return riskLevel;
    }

    public double getCost() {
        return cost;
    }
    public void showInformation(){
        System.out.printf("|%-20s|%-20.2f%%|%-20.2f|\n",name,riskLevel,cost);
    }
}