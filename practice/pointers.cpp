#include<iostream>

int main(){
    // pass by value
    int a = 10;
    int b = a;
    std::cout << "pass by value: " << std::endl;
    std::cout << "a = " << a << std::endl;
    std::cout << "b = " << b << std::endl;
    b = 20;
    std::cout << "a = " << a << std::endl;
    std::cout << "b = " << b << std::endl;

    //pass by reference
    int c = 10;
    int &d = c;
    std::cout << "pass by reference " << c << std::endl;
    std::cout << "c = " << c << std::endl;
    std::cout << "d = " << d << std::endl;
    d = 20;
    std::cout << "c = " << c << std::endl;
    std::cout << "d = " << d << std::endl;
    
    //pass by pointer
    int e = 10;
    int *f = &e;
    std::cout<< "pass by pointer" << std::endl;
    std::cout << "e = " << e << std::endl;
    std::cout << "f = " << f << std::endl;
    *f = 20;
    std::cout << "e = " << e << std::endl;
    std::cout << "f = " << f << std::endl;

    

    return EXIT_SUCCESS;
}