import {useState} from 'react'

export default function MyApp() {
    const [shareCount, setShareCount] = useState(0);

    function shareCountHandler() {
      setShareCount(shareCount+1);
    }

  return (
    <div>
      <h1>Welcome to my app</h1>
      <p><MyButton /></p>
      <p><TextField /></p>
      <p><Radio /></p>
      <p><Checkbox /></p>
      <p><TextArea /></p>
      <p><AboutPage /></p>
      <img className="avatar" src="https://images.fineartamerica.com/images/artworkimages/mediumlarge/1/charlie-chaplin-1925-everett.jpg" />
      <Profile />
      <IfElse />
      <Mapping />
      <EventHandler />
      <h1>Local Hook</h1>
      <LocalHook />
      <LocalHook />
      <h1>Share Hook</h1>
      <ShareHook shareCount={shareCount} shareCountHandler={shareCountHandler}/>
      <ShareHook shareCount={shareCount} shareCountHandler={shareCountHandler}/>
    </div>
  );
}

function MyButton() {
  return (
    <button>
      I'm a button
    </button>
  );
}

function TextField() {
    return (
        <input/>
    )
}

function Radio() {
    return (
        <input type="radio"/>
    )
}

function Checkbox() {
    return (
        <input type="checkbox"/>
    )
}

function TextArea() {
    return (
        <textarea />
    );
}

function AboutPage() {
    return (
        <>
            <h1>About</h1>
            <p>Hello there, <br /> How do you do</p>
        </>
    );
}

const user = {
    name: 'Hedy Lamarr',
    imageUrl: 'https://i.imgur.com/yXOvdOSs.jpg',
    imageSize: 90,
};

function Profile() {
    return (
        <>
            <h1>{user.name}</h1>
            <img
                 className="avatar"
                 src={user.imageUrl}
                 alt={'Photo of ' + user.name}
                 style={{
                    width:user.imageSize,
                    height:user.imageSize
                 }}
            />
        </>
    );
}

function IfElse() {
    let isLoggedIn = false;
    let content;
    if (isLoggedIn) {
        content = <AdminPortal />;
    } else {
        content = <LoginForm />;
    }

    return (
        <div>
            {content}
        </div>
    );

}

function AdminPortal() {
    return (
        <div>
            <h1>Admin Portal</h1>
            <p>Hello User,</p>
        </div>
    );
}

function LoginForm() {
    return (
        <>
            <h1>Login</h1>
            <form>
                <p>Username: <input /> </p>
                <p>Password: <input type="password" /> </p>
                <p><input type="submit" /></p>
            </form>
        </>
    );
}

function Mapping() {
const products = [
  { title: 'Cabbage', isFruit: false, id: 1 },
  { title: 'Garlic', isFruit: false, id: 2 },
  { title: 'Apple', isFruit: true, id: 3 },
];

    const listItems = products.map(product =>
        <li
          key={product.id}
          style={{
            color: product.isFruit ? 'magenta' : 'darkgreen'
          }}
        >
          {product.title}
        </li>
      );

      return (
        <ul>{listItems}</ul>
      );
}

function EventHandler() {

    function handleClick() {
        alert('Button clicked');
    }

    return (
        <button onClick={handleClick}>
            Handle this Event
        </button>
    );
}

function LocalHook() {
    const [count, setCount] = useState(0);

    function handleClick() {
        setCount(count+1);
    }

    return (
        <p>
            <button onClick={handleClick}>
                It clicked {count} times.
            </button>
        </p>
    );
}

function ShareHook({shareCount, shareCountHandler}) {
    return (
        <p>
            <button onClick={shareCountHandler}>
                It clicked {shareCount} times.
            </button>
        </p>
    );
}