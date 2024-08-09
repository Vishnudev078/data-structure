#include <stdio.h>
#include <string.h>
#include <stdlib.h>

// Function prototypes
void passOne(char label[10], char opcode[10], char operand[10], char code[10], char mnemonic[3]);
void display();

int main() {
    // Arrays for reading from input
    char label[10], opcode[10], operand[10];
    
    // Arrays for reading from optab
    char code[10], mnemonic[3];

    // Call the passOne function
    passOne(label, opcode, operand, code, mnemonic);

    return 0;
}

void passOne(char label[10], char opcode[10], char operand[10], char code[10], char mnemonic[3]) {
    int locctr, start, length;
    FILE *fp1, *fp2, *fp3, *fp4, *fp5; // File pointers

    // Open files in read mode
    fp1 = fopen("input.txt", "r");
    fp2 = fopen("optab.txt", "r");

    // Open files in write mode
    fp3 = fopen("symtab.txt", "w");
    fp4 = fopen("intermediate.txt", "w");
    fp5 = fopen("length.txt", "w");

    // Read the first line from the input file
    fscanf(fp1, "%s\t%s\t%s", label, opcode, operand);

    if (strcmp(opcode, "START") == 0) {
        // Convert operand to integer and assign to start
        start = atoi(operand);
        locctr = start;

        // Write to the output file (no locctr for the START line)
        fprintf(fp4, "\t%s\t%s\t%s\n", label, opcode, operand);

        // Read the next line
        fscanf(fp1, "%s\t%s\t%s", label, opcode, operand);
    } else {
        locctr = 0;
    }

    // Iterate till end
    while (strcmp(opcode, "END") != 0) {
        // Write to the intermediate file
        fprintf(fp4, "%d\t%s\t%s\t%s\n", locctr, label, opcode, operand);

        // If label is not empty, write to the symbol table
        if (strcmp(label, "**") != 0) {
            fprintf(fp3, "%s\t%d\n", label, locctr);
        }

        // Reset file pointer for optab.txt
        rewind(fp2);
        // Read from optab (code and mnemonic values)
        fscanf(fp2, "%s\t%s", code, mnemonic);

        // Traverse till the end of the optab file
        while (strcmp(code, "END") != 0) {
            if (strcmp(opcode, code) == 0) {
                // If opcode matches, increment locctr by 1
                locctr += 1;
                break;
            }
            // Read the next line from optab
            fscanf(fp2, "%s\t%s", code, mnemonic);
        }

        // Searching for WORD, RESW, BYTE, RESB keywords and updating locctr
        if (strcmp(opcode, "WORD") == 0) {
            locctr += 3;
        } else if (strcmp(opcode, "RESW") == 0) {
            locctr += 3 * atoi(operand);
        } else if (strcmp(opcode, "BYTE") == 0) {
            locctr += 1;
        } else if (strcmp(opcode, "RESB") == 0) {
            locctr += atoi(operand);
        }

        // Read the next line from the input file
        fscanf(fp1, "%s\t%s\t%s", label, opcode, operand);
    }

    // Write the last line to the intermediate file
    fprintf(fp4, "%d\t%s\t%s\t%s\n", locctr, label, opcode, operand);

    // Close all files
    fclose(fp4);
    fclose(fp3);
    fclose(fp2);
    fclose(fp1);

    // Display outputs
    display();

    // Calculate the length of the program
    length = locctr - start;
    fprintf(fp5, "%d", length);
    fclose(fp5);

    printf("\nThe length of the code: %d\n", length);
}

void display() {
    char str;
    FILE *fp1, *fp2, *fp3;

    // Display content of Input Table
    printf("\nThe contents of Input Table:\n\n");
    fp1 = fopen("input.txt", "r");
    str = fgetc(fp1);
    while (str != EOF) {
        printf("%c", str);
        str = fgetc(fp1);
    }
    fclose(fp1);

    // Display content of Output Table
    printf("\n\nThe contents of Output Table:\n\n");
    fp2 = fopen("intermediate.txt", "r");
    str = fgetc(fp2);
    while (str != EOF) {
        printf("%c", str);
        str = fgetc(fp2);
    }
    fclose(fp2);

    // Display content of Symbol Table
    printf("\n\nThe contents of Symbol Table:\n\n");
    fp3 = fopen("symtab.txt", "r");
    str = fgetc(fp3);
    while (str != EOF) {
        printf("%c", str);
        str = fgetc(fp3);
    }
    fclose(fp3);
}
