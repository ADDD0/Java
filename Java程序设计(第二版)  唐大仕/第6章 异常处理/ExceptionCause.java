public class ExceptionCause {
	public static void main(String[] args) {
		try {
			BankATM.GetBalanceInfo(12345L);
		} catch (Exception e) {
			System.out.println("出现了异常: " + e);
			System.out.println("内部原因: " + e.getCause());
		}
	}
}

class DataHouse {
	public static void FindData(long ID) throws DataHouseException {
		if (ID > 0 && ID < 1000)
			System.out.println(ID);
		else
			throw new DataHouseException("已到文件尾");
	}
}

class BankATM {
	public static void GetBalanceInfo(long ID) throws MyAppException {
		try {
			DataHouse.FindData(ID);
		} catch (DataHouseException e) {
			throw new MyAppException("账号不存在", e);
		}
	}
}

class DataHouseException extends Exception {
	public DataHouseException(String message) {
		super(message);
	}
}

class MyAppException extends Exception {
	public MyAppException(String message) {
		super(message);
	}
	public MyAppException(String message, Exception cause) {
		super(message, cause);
	}
}