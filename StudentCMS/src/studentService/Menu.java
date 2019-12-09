package studentService;

import java.util.List;

import pojo.User;
import studentDAO.IUserDAOImpl;
import util.InputData;

public class Menu {
	public static void main(String[] args) {
		new Menu();
	}

	public Menu() {
		while (true) {
			this.show();
		}
	}

	public void show() {
		IUserDAOImpl impl = new IUserDAOImpl();
		InputData input = new InputData();
		List<User> list = null;
		User user = new User();
		System.out.println("--------人员信息管理系统--------");
		System.out.println("1.增加人员");
		System.out.println("2.按编号删除人员");
		System.out.println("3.按编号修改人员信息");
		System.out.println("4.按编号查询人员信息");
		System.out.println("5.按(姓名,性别)模糊查询人员信息");
		System.out.println("6.查看全部人员信息");
		System.out.println("0.退出");

		InputData choice = new InputData();
		switch (choice.getInt("你的选择", "Wrong")) {
		case 1:
			System.out.println("你的选择是1.增加人员");
			user.setId(input.getInt("编号", "Wrong"));
			user.setName(input.getString("姓名"));
			user.setSex(input.getString("性别"));
			user.setBirthday(input.getDate("出生日期", "Wrong"));
			try {
				if (impl.doInsert(user))
					System.out.println("插入成功");
				else
					System.out.println("插入失败");
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case 2:
			System.out.println("你的选择是2.按编号删除人员");
			user.setId(input.getInt("编号", "Wrong"));
			try {
				if (impl.doDelete(user.getId()))
					System.out.println("删除成功");
				else
					System.out.println("删除失败");
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case 3:
			System.out.println("你的选择是3.按编号修改人员信息");
			user.setId(input.getInt("编号", "Wrong"));
			user.setName(input.getString("姓名"));
			user.setSex(input.getString("性别"));
			user.setBirthday(input.getDate("出生日期", "Wrong"));
			try {
				if (impl.doUpdate(user.getId(), user))
					System.out.println("修改成功");
				else
					System.out.println("修改失败");
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case 4:
			System.out.println("你的选择是4.按编号查询人员信息");
			user.setId(input.getInt("编号", "Wrong"));
			try {
				user = impl.findById(user.getId());
				System.out.println(user);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case 5:
			System.out.println("5.按(姓名,性别)模糊查询人员信息");
			user.setName(input.getString("姓名/性别"));
			try {
				list = impl.findByKey(user.getName());
				for (User u : list)
					System.out.println(u);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case 6:
			System.out.println("你的选择是6.查看全部人员信息");
			try {
				list = impl.findAllStudent();
				for (User u : list)
					System.out.println(u);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case 0:
			System.out.println("谢谢使用本系统");
			System.exit(1);
			break;
		default:
			System.out.println("请选择正确的操作！");
		}
	}
}