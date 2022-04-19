#include<iostream>
#include<string>


void reverseString(std::string str){
    for(int i =str.length()-1; i >=0; i--){
        std::cout <<str[i];
    }
}
int main(){
std::string aString;


std::cout << "Enter a string" << std::endl;
std::getline(std::cin, aString);
reverseString(aString);

return 0;

}