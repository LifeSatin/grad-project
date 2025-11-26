export function load({ cookies }) {
    const token = cookies.get("token");
    console.log(token);
    return {token};
}