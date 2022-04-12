#include<iostream>
#include "color.h"

int main() {
    Color limegreen{137,235,52};
    Color violetish{235,52,52};
    Color brightpink{235,52,125};
    std::cout << limegreen.colorize("Green") << ' '
              << violetish.colorize("Stan Red Velvet") << ' '
              << brightpink.colorize("Pink") << "\n\n";

    int red, green, blue;
    std::cout << "Enter rgb values\n"; 
    std::cin >> red >> green >> blue;
    Color color{red, green, blue};
    std::cout << color.colorize(color.to_string()) << std::endl;
}

