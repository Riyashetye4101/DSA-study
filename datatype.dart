/*
data types in dart:-
int
double
String
bool
dynamic
null
*/

main() {
  // Integer
  int amount1 = 100;
  var amount2 = 1900;

  print('Amount1: $amount1 | Amount2: $amount2 \n');

  // double
  double price = 100.012;
  var price2 = 19000.0121;
  print('price: $price | price2: $price2 \n');

  // string
  String name = "Riya Shetye";
  var name2 = "new name";
  print('real name: $name | new name: $name2 \n');

  // Boolean
  bool value = true;
  var value1 = false;
  print("value: $value | value1: $value1 \n");

  // dynamic where the data type can be change any time;
  dynamic data = "korean dramas";
  print('data value as string: $data \n');
  data = 1020;
  print('data value as integer: $data \n');

  var empty = null;
  print("value of empty: $empty");
}
