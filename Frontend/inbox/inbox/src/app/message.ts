export class Message {
    public id: number;
    public text: string;
    public title: string;
    public sender: Person;
    public recipient: Person;
    public isRead: boolean;

    public constructor(
        id: number,
        text: string,
        title: string,
        sender: Person,
        recipient: Person,
        isRead: boolean
    ){
        this.id = id;
        this.text = text;
        this.title = title;
        this.sender = sender;
        this.recipient = recipient;
        this.isRead = isRread;
    }
}
