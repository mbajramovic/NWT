export class Location {
    public id: number;
    public adress: string;
    public city: string;
    public country: string;

    constructor(
        id: number,
        adress: string,
        city: string,
        country: string
    ){
        this.id = id;
        this.adress = adress;
        this.city = city;
        this.country = country;
    }
}
