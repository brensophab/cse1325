#include "color.h"
#include <iostream>
#include<string>

Color::Color(int red, int green, int blue): _red{red}, _green{green}, _blue{blue} {}
    std::string Color::to_string(){
        return "(" + std::to_string(_red) + "," + std::to_string(_green) + "," + std::to_string(_blue) + ")";
    }

std::string Color::colorize(std::string text){
    return "\033[38;2;" + std::to_string(_red) + ";" + std::to_string(_green) + ";" + std::to_string(_blue) + 'm' + text + "\033[0m";

}

int main() {
    Color limegreen{137,235,52};
    Color violetish{235,52,52};
    Color brightpink{235,52,125};
    std::cout << limegreen.colorize("Green") << ' ' << violetish.colorize("Stan Red Velvet") << ' ' << brightpink.colorize("Pink") << "\n\n";

    int red, green, blue;
    std::cout << "RGB values(R + G + B)  "; 
    std::cin >> red >> green >> blue;
    Color color{red, green, blue};
    std::cout << color.colorize(color.to_string()) << std::endl;
}
