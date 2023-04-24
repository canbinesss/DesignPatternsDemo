package com.example.design.abstracfactory;

import org.yaml.snakeyaml.events.Event;

/**
 * 抽象工厂模式
 */
public class AbstractFactoryTest {
    public static void main(String[] args) {
        IDatabaseUtils iDatabaseUtils = new OracleDatabaseUtils();
        IConnection connection = iDatabaseUtils.createConnection();
        connection.connect();
        ICommand command = iDatabaseUtils.createCommand();
        command.command();
    }
}

// 变化的部分。mysql / oracle / 。。。。
// 变化中找共性  connection，command

interface IConnection {
    // 连接
    void connect();
}

interface ICommand {
    // 命令发送
    void command();
}

interface IDatabaseUtils {
    IConnection createConnection();
    ICommand createCommand();
}
//------------------mysql------------------
class MysqlConnection implements IConnection {
    @Override
    public void connect() {
        System.out.println("mysql connect");
    }
}

class MysqlCommand implements ICommand {
    @Override
    public void command() {
        System.out.println("mysql command");
    }
}

class MysqlDatabaseUtils implements IDatabaseUtils {
    @Override
    public IConnection createConnection() {
        return new MysqlConnection();
    }

    @Override
    public ICommand createCommand() {
        return new MysqlCommand();
    }
}

class OracleConnection implements IConnection {
    @Override
    public void connect() {
        System.out.println("oracle connect");
    }
}
//------------------oracle------------------
class OracleCommand implements ICommand {
    @Override
    public void command() {
        System.out.println("oracle command");
    }
}

class OracleDatabaseUtils implements IDatabaseUtils {
    @Override
    public IConnection createConnection() {
        return new OracleConnection();
    }

    @Override
    public ICommand createCommand() {
        return new OracleCommand();
    }
}