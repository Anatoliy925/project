package lpnu.service.impl;

import lpnu.dto.UserDTO;
import lpnu.entity.User;
import lpnu.mapper.UserMapper;
import lpnu.repository.UserRepository;
import lpnu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.getAllUsers().stream()
                        .map(UserMapper::toDTO)
                        .collect(Collectors.toList());
    }

    @Override
    public UserDTO create(UserDTO userDTO) {
        User user = UserMapper.toEntity(userDTO);

        userRepository.save(user);

        return UserMapper.toDTO(user);
    }

    @Override
    public void delete(Long id) {
       userRepository.delete(id);
    }

    @Override
    public UserDTO update(UserDTO userDTO) {
        User user = UserMapper.toEntity(userDTO);

        userRepository.update(user);

        return UserMapper.toDTO(user);
    }

    @Override
    public UserDTO findById(Long id) {
        return UserMapper.toDTO(userRepository.findById(id));
    }

    public static void main(String[] args) {
        Map<Integer, Integer> q = new HashMap<>();

        q.put(1,1);
        q.put(null,2);
        q.put(null,3);
        q.put(4,1);
        q.put(1,1);

        System.out.println(q);
    }
}
