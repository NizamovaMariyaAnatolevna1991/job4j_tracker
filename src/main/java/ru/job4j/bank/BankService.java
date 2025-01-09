package ru.job4j.bank;

import ru.job4j.bank.Account;
import ru.job4j.bank.User;

import java.util.*;

/**
 * Класс описывает банковсксий сервис
 * @author Masha
 * @version 1.0
 */
public class BankService {
    /**
     * Все пользователи системы с привязанными к ним счетами хранятся в виде карты типа Map
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход пользователя и добавляет его в систему, если его еще нет
     * @param user пользователь, который добавляется в систему
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод принимает паспорт пользоателя, который является ключом карты Map,
     * по которому происходит удаление пользователя из системы
     * @param passport
     */
    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    /**
     * Метод принимает паспорт пользоателя и счет,
     * который необходимо добавить пользователю
     * При этом происходит проверка, что такого счета
     * у пользователя нет
     * @param passport
     * @param account
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
               accounts.add(account);
            }
        }
    }

    /**
     * Метод принимает паспорт, по которому происходит поиск пользователя
     * @param passport
     * @return возвращает пользователя, если пользователя нет - возвращает null
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод ищет счет по реквизитам счета
     * Метод принимает на вход паспорт пользователя и реквизиты счета
     * Если пользователь с таким паспортом существует, осуществляется поиск счета
     * @param passport
     * @param requisite
     * @return возвращается счет, если счет отсутствует метод возвращает null
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Метод предназначен для перечисления денег с одного счета на другой
     * @param sourcePassport паспорт отправителя
     * @param sourceRequisite реквизиты счета, с которого осуществляется перевод средств
     * @param destinationPassport паспорт получателя
     * @param destinationRequisite реквизиты счета, на который осуществляется перевод средств
     * @param amount сумма которую необходимо перевести
     * @return если деньги переведены метод вернет true, Если счет для перевода не найден
     * или денег для перевода недостаточно - false
     */
    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        Account srcAccount = findByRequisite(sourcePassport, sourceRequisite);
        Account destAccount = findByRequisite(destinationPassport, destinationRequisite);

        if (srcAccount != null && destAccount != null && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            return true;
        }

        return false;
    }

    /**
     * Метод позволяет получить пользователя из списка пользователей
     * @param user
     * @return
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
