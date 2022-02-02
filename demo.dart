import 'dart:io';

main() {
  stdout.writeln("what is your name?");
  var name = stdin.readLineSync();
  print("hello! $name");
}
