main() {
  // for loop, while and do-while are similar as in java
  // for-in loop
  var num = [1, 2, 3, 4, 5];
  for (var i in num) {
    print(i);
  }

  // forEach loop
  // 1st method
  print("first method for forEach");
  num.forEach((n) => print(n));

  print("second method for forEach");
  num.forEach(printnum);
}

void printnum(num) {
  print(num);
}
