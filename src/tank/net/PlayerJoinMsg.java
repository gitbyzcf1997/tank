package tank.net;

import tank.Dir;
import tank.Group;

import java.util.UUID;

/**
 * @Auther:ZhenCF
 * @Date: 2022-02-14-16:46
 * @Description: tank.net
 * @version: 1.0
 */
public class PlayerJoinMsg extends Msg {
    private static final MsgType type=MsgType.PlayerJoin;
    int x,y;
    Dir dir;
    boolean moving;
    Group group;
    public UUID id;
    String name;
}
