let str: String = "Hello world";
let bool:boolean = true;
let num: number = 5;
let firstname: String = "nitin";
let lastname: String = "rane";

console.log(str);
console.log(bool)
console.log(num);
console.log(`Hi ${firstname} ${lastname}`);

let totalNum: number = 0;
for (let i = 0; i < 5; i++) {
    totalNum += i;
}
console.log(`Total of all numbers is ${totalNum}`);

let weekDays:String[] = ["Sun", "Mon", "Tue", "Wed"];
weekDays.push("Thu");
weekDays.push("Fri");
weekDays.push("Sat");

for (let day of weekDays) {
    if ("Fri" == day) {
        console.log(`${day} is my favourite day`)
    } else {
        console.log(day);
    }
}

