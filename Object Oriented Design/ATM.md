## Automated Teller Machine Design (ATM)

**NOTE:**  
- This is just a naive design. Read ATM state Pattern.

### Solutioning:
 
> **Requirements:**  
> Withdrawal  
> Deposit  
> Pin Change  
> Check balance  

<br>

> **APIs:**  
> withdrawal(accountId, amount, pin)  
> deposit(accountId, amount, pin)  
> checkBalance(accountId, pin)  
> changePin(accountId, pin)  


**Let's have a look at the data classes & business logic classes:**   

```java
class User{
	id
	name
}

class Account{
	id
	userId
	branchAddr
	cardId
}

class Card{
	accountId
	number
	pin
	expiry
	cvv
	Type
	PaymentNetwork
}

enum PaymentNetwork{
  Master, VISA
}

enum Type{
	Debit, Credit
}

enum Denomination{
	100, 500, 1000
}

class Bank{

  boolean withdraw(userId, amount, pin){
    //Checks pin …...throws exception for invalid pin
    //Checks balance > amount …...throws exception for insufficient balance
    //deducts amount from balance

    return true or false
  }	

  boolean deposit(userId, amount, pin){
    //Checks pin …...throws exception for invalid pin
    //adds amount to balance

    return true or false
  }	

  int getBalance(accountId, pin){
    //Checks pin …...throws exception for invalid pin
    return balance
  }	

  boolean changePin(accountId, pin){
    //Checks pin …...throws exception for invalid pin
    return true or false
  }	
}


class ATM{
  Map<Denomination, Count> map
	
  withdrawal(accountId, amount, pin){
    isAmountPossibleByDenomination
    bank.withdraw(accountId, amount, pin)
  }	

  deposit(accountId, amount, pin){
    validateNotes…...throws exception for nakli notes
    bank.deposit(accountId, amount, pin)
  }	

  checkBalance(accountId, pin){
    bank.getBalance(accountId, pin)
  }	

  changePin(accountId, pin){
    bank.changePin(accountId, pin)
  }	
}

```  


 
