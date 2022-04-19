#include<iostream>
#include<string>
void rot13(std::string &s){
    std::string key = "nopqrstuvwxyzabcdefghijklm";
    for(char &c : s){
        if(c == ' ') continue;
        if('a' > c || c > 'z') throw new std::runtime_error{"not a letter" + std::string{c}};
        c = key[c - 'a'];
    }
}
    int main(){
    std::string s;
    std::cout << "Enter a string: ";
    std::getline(std::cin, s);
    rot13(s);
    std::cout << "Rot13: " << s << std::endl;
    return EXIT_SUCCESS;
}