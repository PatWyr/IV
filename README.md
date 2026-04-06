
# IV
### Prerequisites
1. Java at least 21
2. Maven
3. IDE
4. Turned off any AI assistants

## Task
The task is to implement a bank account. It needs to contain the name,
surname,
balance,
account type (for now a bank only has two types of accounts standard and VIP) 
and ID which will be generated automatically and needs to be compliant with the IBAN standard. (https://en.wikipedia.org/wiki/International_Bank_Account_Number) (https://simple.wikipedia.org/wiki/International_Bank_Account_Number)
all accounts are polish accounts.
Create a bank class, it needs to store accounts. Accounts in a bank are unique based on IBAN. Two accounts cannot have the same IBAN.
Implement a method to make a payment; it will change the balance based on the requested amount, additionally bank takes a fee per transaction,
for Standard Account it is 3% and a VIP account is 1%. Implement methods to add and remove accounts.

