main() {
  // string --> int
  var num = int.parse('1');
  bool value = (num == 1);
  print(value);

  // string --> float
  var price = double.parse('110.201');
  value = (price == 110.201);
  print(value);

  // int --> string
  print(num.toString());

  // double --> string
  print(3.1453
      .toStringAsFixed(2)); // this function will roundoff this double value

  print('1'.runtimeType);
}
