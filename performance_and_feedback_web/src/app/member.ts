export class Member {
    id: number;
    email: string;
    doj: Date;
    name: string;
    newCertification: number;
    trainingAndSeminars: number;
    webinars: number;
    others: number;

    constructor( id: number, email: string , doj: Date, name: string, newCertification: number, trainingAndSeminars: number,
        webinars: number, others: number) { 
        this.id = id;
        this.email = email;
        this.doj = doj;
        this.name = name;
        this.newCertification = newCertification;
        this.trainingAndSeminars = trainingAndSeminars;
        this.webinars = webinars;
        this.others = others;
    }
}