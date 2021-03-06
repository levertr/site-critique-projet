package fr.dawan.sitecritiqueprojet.mappers;

import org.modelmapper.ModelMapper;

import fr.dawan.sitecritiqueprojet.beans.User;
import fr.dawan.sitecritiqueprojet.dto.UserDto;

public class UserMapper {
    private ModelMapper mapper;

    public UserMapper() {
        mapper = new ModelMapper();
    }

    public UserDto toDto(User u) {
        mapper.typeMap(User.class, UserDto.class).addMappings(mapper -> {
            mapper.map(src -> src.getId(), UserDto::setId);
            mapper.map(src -> src.getUsername(), UserDto::setUsername);
            mapper.map(src -> src.getLastname(), UserDto::setLastname);
            mapper.map(src -> src.getFirstname(), UserDto::setFirstname);
            mapper.map(src -> src.getPassword(), UserDto::setPassword);
            mapper.map(src -> src.getEmail(), UserDto::setEmail);
            mapper.map(src -> src.getAge(), UserDto::setAge);
            mapper.map(src -> src.getDescription(), UserDto::setDescription);
            mapper.map(src -> src.getCatchPhrase(), UserDto::setCatchPhrase);
            mapper.map(src -> src.getRegistrationDate(), UserDto::setRegistrationDate);
            mapper.map(src -> src.getLastConnection(), UserDto::setLastConnection);
        });
        return mapper.map(u, UserDto.class);
    }

    public User fromDto(UserDto uDto) {
        mapper.typeMap(UserDto.class, User.class).addMappings(mapper -> {
            mapper.map(src -> src.getId(), User::setId);
            mapper.map(src -> src.getUsername(), User::setUsername);
            mapper.map(src -> src.getLastname(), User::setLastname);
            mapper.map(src -> src.getFirstname(), User::setFirstname);
            mapper.map(src -> src.getPassword(), User::setPassword);
            mapper.map(src -> src.getEmail(), User::setEmail);
            mapper.map(src -> src.getAge(), User::setAge);
            mapper.map(src -> src.getDescription(), User::setDescription);
            mapper.map(src -> src.getCatchPhrase(), User::setCatchPhrase);
            mapper.map(src -> src.getRoles(), User::setRoles);
            mapper.map(src -> src.getLastConnection(), User::setLastConnection);
        });
        return mapper.map(uDto, User.class);
    }
}
