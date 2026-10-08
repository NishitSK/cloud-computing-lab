#include <stdio.h>

int main(void)
{
    int a, b;

    printf("Enter two numbers: ");
    if (scanf("%d %d", &a, &b) != 2) {
        printf("Please enter two whole numbers.\n");
        return 1;
    }

    printf("Sum of %d and %d is %d\n", a, b, a + b);
    return 0;
}
