void main() {
  var list = ["Riya", "gayatri", 10, 100.01, true];
  for (var n in list) {
    print(n);
  }
  // specifing the type of list:-
 
  List<String> name = ["JAck","john"];
  print("name variable: $name");
  // here list are mutable.
  name[1]="ria";  
  print("updated value of name: $name");

  // creating the constant list or immutable list
//  List<int> num= const [1,2,3,4];
//  print(num);
//  num[2]=32;

   // pointing the two variables to same list
   List name2 = [...name]; // this statement is used to create the new object
   name[1]='priya';

  
   print("name2 is pointing to new instance $name2");
   print("name is pointing to old instance $name");
}
