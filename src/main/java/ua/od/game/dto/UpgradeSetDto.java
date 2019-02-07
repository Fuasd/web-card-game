package ua.od.game.dto;

public class UpgradeSetDto {
    Integer id;
    Integer setId;
    Integer upgradeId;
    Float amount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSetId() {
        return setId;
    }

    public void setSetId(Integer setId) {
        this.setId = setId;
    }

    public Integer getUpgradeId() {
        return upgradeId;
    }

    public void setUpgradeId(Integer upgradeId) {
        this.upgradeId = upgradeId;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "UpgradeSetDto{" +
                "id=" + id +
                ", setId=" + setId +
                ", upgradeId=" + upgradeId +
                ", amount=" + amount +
                '}';
    }
}
