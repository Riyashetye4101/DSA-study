class Num {
  int no = 10;
}

main() {
  int num1 = 10;
  int num2 = 100;
  print(num1 + num2);

  var amount = 89.01;
  print(amount + num1);

  print(amount ~/ num1);

  print(amount % num1);

  print(num1 * num2);

  print(num1++);

  // num aware operators:-
  var n1 = Num();
  var n2;

  print("details about the numbers:");
  print("$n1");
  var number = n2?.no ?? 0;
  print(number);
  // here it is first checking if n2 is a valid object
  //for to acess the no property and the ?? will check if n2?. is returing null
  // value if yes then default 0 value will be return

  // what if we want to assign the new value if variable having the null value
  var edge;
  print(edge ??= 100);
  print(edge);

  // new operators:- write a program to check if num1 is integer type
  if (num1 is double) {
    print("it is a double type");
  } else {
    print("it is integer type");
  }

  print(num1 is! String);
}
/* 
for, while, do-while loop are same as previous language
if, if-else , else if and switch are statement are same as previous.
 */