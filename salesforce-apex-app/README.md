# Salesforce Apex Hello App

A simple application written in **Apex** on the Salesforce platform. It builds a welcome message for a given name, writes it to the debug log and returns it.

## Features

- A single reusable Apex class
- Static method that can be called without creating an object
- Output visible in the Developer Console debug log
- Runs entirely on Salesforce, nothing to install locally

## Tech Stack

- Salesforce Apex
- Salesforce Developer Edition org
- Salesforce Developer Console
- Execute Anonymous window

## Project Flow

1. Sign up for a free Developer Edition org at https://developer.salesforce.com/signup and log in.
2. Click the gear icon and open **Developer Console**.
3. Choose **File > New > Apex Class**, name it `HelloApex` and click **OK**.
4. Replace the class body with the contents of [HelloApex.cls](HelloApex.cls) and save.
5. Open **Debug > Open Execute Anonymous Window**.
6. Enter the call shown below, tick **Open Log** and click **Execute**.
7. In the log, tick **Debug Only** to see the message.

## Apex Service

The class is in [HelloApex.cls](HelloApex.cls). It is called with:

```apex
HelloApex.greet('Nishit');
```

Line written to the debug log:

```
Welcome to Apex programming, Nishit!
```

## Screenshots

Not added yet. To capture after the run:

- The `HelloApex` class open in the Developer Console
- The debug log showing the welcome message
