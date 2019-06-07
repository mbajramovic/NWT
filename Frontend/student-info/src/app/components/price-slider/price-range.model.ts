export default class PriceRangeModel {
    minValue: number;
    maxValue: number;

    constructor(minValue: number, maxValue: number) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }
}