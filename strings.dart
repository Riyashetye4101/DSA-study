main() {
  // different way of defining the string values.
  String s1 = "real name: Riya Shetye | new name: new name \n";
  String s2 = 'real name: Riya Shetye | new name: new name \n';
  String s3 = 'it\'s my new house \n';
  String s4 = "it's my new house";
  print(s1 + s2 + s3 + s4);

  // raw string
  String s = r'In raw string not even \n gets the special treatment';
  print('raw string: $s');

  // multiline strings:
  String s_mult1 =
      '''this is multiline string defining way do you like it or not
      this new way also
      🤪

      by..........
  ''';
  print(s_mult1);
  String s_mult2 = """
  this is a new way
  doyou like or
  not 	😀
  """;
  print(s_mult2);
}
