package www.wevvv.smart_control.initcontrol.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import www.wevvv.smart_control.initcontrol.model.Users;

@Mapper
@Repository
public interface UsersMapper {
    public Users getUserId(Integer id);

    public Users getUsers(String username);
}
