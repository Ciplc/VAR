// Import libs
#include <iostream>
#include <fstream>
#include <string>
#include <sstream>
using namespace std;

// Declare Variables
string lifterName;
string date;
string goal;
double dryMass;
double wetMass;
double expectedAltitude;
double actualAltitude;

// Write contents passed to it to a file
void writeToFile(){

    // Open file for logging
    ofstream file("log.txt", ios::out | ios::app);
    if(file.is_open()){
        file << lifterName << "\n";
        file << date << "\n";
        file << goal << "\n";
        file << dryMass << "\n";
        file << wetMass << "\n";
        file << expectedAltitude << "\n";
        file << actualAltitude << "\n";
        file.close();
    }
}

// Get User Input
void getUserInput(){

    // Strings
    std::cout << "What is the Lifter Name?\n";
    std::cin.ignore();
    std::getline(cin, lifterName);
    std::cout << "What is the date?\n";
    std::cin >> date;
    std::cout << "What is the goal?\n";
    std::cin.ignore();
    std::getline(cin, goal);

    // Doubles
    std::cout << "What is the Dry Mass?\n";
    std::cin >> dryMass;
    std::cout << "What is the Wet Mass?\n";
    std::cin >> wetMass;
    std::cout << "What is the Expected Altitude?\n";
    std::cin >> expectedAltitude;
    std::cout << "What is the Actual Altitude?\n";
    std::cin >> actualAltitude;
}

// Run the actual program
int main(){
    getUserInput();
    writeToFile();
    return 0;
}
