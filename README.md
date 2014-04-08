CurrencyPlus
===========

Fast, Efficient and Easy to use, CurrencyPlus is the best Currency plugin ever created for the bukkit forums, it allows Users to have full control of their Money, It allows Administrators to check what is going on with money around the server, it is fully customizable and easy to use.

Commands
------

`/pay <user> <amount>` to send the amount of money desired to the user

`/set <user> <amount>` to set the amount of money desired to the user (Only used by Administrators)

`/take <user> <amount>` to take the desired amount of money from a player. (Only used by Administrators)

Configuration
------

CurrencyPlus has a really easy to follow configuration, this section is intended to allow the Owners to see how to use the configuration.
If you don't know how to access a Configuration Simply go into your Plugins Folder > CurrencyPlus > config.yml

Some of the features it has are the following, per example, if i want to name my currency Dollars, i would go to my config.yml and do the following:

`Currency-Name: Dollars`

That would allow the plugin to read it and  when some transaction is going on it will display the currency name as Dollars

Developer API
------

Currency Plus includes a nice and easy to use API which allows plugin developers to create their own plugins with this code. It includes several methods stated below:

`getMoney()` will return the amount of money a player has.

 `setMoney()` will set the amount of money a player will have.

 `addMoney()` will add the desired amount of money to the amount the player already has.

 `takeMoney()` will remove the desired amount of money to the amount the player already has.

  `isInteger()` will check if a string is an Integer, if it is it will return true and if its not it will return false, is is used to avoid NumberFormatExceptions.

   `getCurrencyName()` will return the value set in the config, for example 'Dollars'

Credits
------
- DevRosemberg's File Util
- Apache for creating Maven.

JavaDocs
------

You can find our JavaDocs in here: http://devrosemberg.com/javadocs/currencyplus/
